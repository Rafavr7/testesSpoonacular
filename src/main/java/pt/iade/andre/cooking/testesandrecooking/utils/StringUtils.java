package pt.iade.andre.cooking.testesandrecooking.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StringUtils {

    /**
     * Class Constants
     */
    private final static int SUBSTRING_GET_POS = 3;

    private final static int SUBSTRING_IS_POS = 2;

    private final static String SEPARATOR = "; ";

    private final static String METHOD_EXCEPTION = "getClass";

    private final static String MASK_DATE = "dd/MM/yyyy";

    // Private Constructor
    private StringUtils() {
        // EMPTY
    }

    /**
     *
     * @param objClass
     * @param objToString
     * @return
     */
    public static String toString(final Class<?> objClass, final Object objToString) {
        final StringBuffer sBuffer = new StringBuffer();
        sBuffer.append(objClass.getSimpleName());
        sBuffer.append(" [ ");

        final Method[] classMethods = objClass.getMethods();
        for (Method tempMethod : classMethods) {

            final boolean startsWithGet = tempMethod.getName().startsWith("get");
            final boolean startsWithIs = tempMethod.getName().startsWith("is");
            final boolean exception = tempMethod.getName().startsWith(METHOD_EXCEPTION);

            if ((tempMethod.getParameterTypes().length == 0) && (startsWithGet || startsWithIs) && (!exception)) {
                try {
                    final Object tempObject = tempMethod.invoke(objToString, new Object[]{});

                    if (startsWithGet) {
                        if (tempObject != null) {
                            if (GregorianCalendar.class.equals(tempObject.getClass())) {
                                sBuffer.append(tempMethod.getName().substring(SUBSTRING_GET_POS))
                                        .append(" = ")
                                        .append(formatDateToString((GregorianCalendar) tempObject))
                                        .append(SEPARATOR);
                            }
                            else {
                                sBuffer.append(tempMethod.getName().substring(SUBSTRING_GET_POS))
                                        .append(" = ")
                                        .append(tempObject)
                                        .append(SEPARATOR);
                            }
                        }
                    }
                    else {
                        sBuffer.append(tempMethod.getName().substring(SUBSTRING_IS_POS))
                                .append(" = ")
                                .append(tempObject)
                                .append(SEPARATOR);
                    }
                } catch (final InvocationTargetException | IllegalArgumentException | IllegalAccessException ex) {
                    System.err.println(ex.getMessage() + ex);
                }
            }
        }

        sBuffer.append(']');
        return sBuffer.toString();
    }

    /**
     *
     * @param date
     * @return
     */
    public static String formatDateToString(final Calendar date) {
        String dateFormated = null;

        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat(MASK_DATE);
            Date temp = date.getTime();
            dateFormated = dateFormat.format(temp);
        }

        return dateFormated;
    }
}
