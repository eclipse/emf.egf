package html.modelview;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class myPattern
{
  protected static String nl;
  public static synchronized myPattern create(String lineSeparator)
  {
    nl = lineSeparator;
    myPattern result = new myPattern();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl; //$NON-NLS-1$
  protected final String TEXT_1 = NL + "//default content" + NL + NL; //$NON-NLS-1$

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
// add initialisation of the pattern variables (declaration has been already done).
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
