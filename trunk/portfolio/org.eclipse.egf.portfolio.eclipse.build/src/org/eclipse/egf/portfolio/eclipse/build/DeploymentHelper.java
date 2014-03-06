package org.eclipse.egf.portfolio.eclipse.build;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

public class DeploymentHelper {
	enum RequestType {
		GET,
		POST
	}

	private String serverUrl;
	private String login;
	private String password;
	
	/**
	 * No login or password is provided
	 * The authentication will be done by UI by org.eclipse.ui.internal.net.auth.NetAuthenticator
	 * @param serverUrl
	 */
	public DeploymentHelper(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	
	public DeploymentHelper(String serverUrl, String login, String password) {
		this.serverUrl = serverUrl;
		this.login = login;
		this.password = password;
	}
	
	public void pullConfig(File file, String jobName) throws IOException {
		receiveConfig(file, getConfigUrl(serverUrl, jobName));
	}
	
	public void pushConfig(File file, String jobName) throws IOException {
		if (testUrl(getJobUrl(serverUrl, jobName)))
			sendConfig(file, getConfigUrl(serverUrl, jobName));
		else
			sendConfig(file, getCreateUrl(serverUrl, jobName));
	}
	
	protected String getConfigUrl(String serverUrl, String jobName) throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		builder.append(getJobUrl(serverUrl, jobName));
		builder.append("/config.xml");
		return builder.toString();
	}

	private String getJobUrl(String serverUrl, String jobName) throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		builder.append(serverUrl);
		builder.append("/job/");
		builder.append(URLEncoder.encode(jobName, "UTF8"));
		return builder.toString();
	}
	
	protected String getCreateUrl(String serverUrl, String jobName) throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		builder.append(serverUrl);
		builder.append("/createItem?name=");
		builder.append(URLEncoder.encode(jobName, "UTF8"));
		return builder.toString();
	}

	protected boolean testUrl(String serverUrl) throws IOException {
		HttpURLConnection openConnection = openConnection(serverUrl, RequestType.GET); 
		
		if (openConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
			return false;
		}

		checkError(openConnection);
		return true;
	}

	protected void receiveConfig(File file, String configUrl) throws IOException {
		HttpURLConnection openConnection = openConnection(configUrl, RequestType.GET); 
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));

		readerToWriter(bufferedWriter, bufferedReader);
		
		checkError(openConnection);
	}

	protected void sendConfig(File file, String configUrl) throws IOException {
		HttpURLConnection openConnection = openConnection(configUrl, RequestType.POST);

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(openConnection.getOutputStream()));
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

		readerToWriter(bufferedWriter, bufferedReader);
		
		checkError(openConnection);
	}

	protected void readerToWriter(BufferedWriter bufferedWriter, BufferedReader bufferedReader) throws IOException {
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		}
		bufferedReader.close();
		bufferedWriter.flush();
		bufferedWriter.close();
	}	
	
	protected HttpURLConnection openConnection(String url, RequestType requestType) throws IOException {
		HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
		openConnection.setRequestMethod(requestType.toString());
		openConnection.setRequestProperty("Content-Type", "text/xml");
		openConnection.setDoOutput(true);
		openConnection.setDoInput(true);
		openConnection.setUseCaches(false);
		
		String authString = login + ":" + password;
		String encoded = new String(Base64.encodeBase64(authString.getBytes()));
		openConnection.setRequestProperty("Authorization", "Basic " + encoded);
		
		return openConnection;
	}

	protected void checkError(HttpURLConnection openConnection) throws IOException {
		if (openConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new IOException(openConnection.getResponseMessage());
		}
	}
}
