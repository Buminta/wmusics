package wmusics.hemlock.com.wheremusics.utils;

import android.content.Context;

import com.google.android.gms.analytics.StandardExceptionParser;

import java.util.Collection;

/**
 * Created by me866chuan on 1/19/15.
 */
public class AnalyticsExceptionParser extends StandardExceptionParser {
    public AnalyticsExceptionParser(Context context,
                                    Collection<String> additionalPackages) {
        super(context, additionalPackages);
    }

    @Override
    public String getDescription(String threadName, Throwable t) {
        return getDescription(getCause(t), getBestStackTraceElement(getCause(t)), threadName);
    }

    protected String getDescription(Throwable cause, StackTraceElement element, String threadName) {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append(cause.getClass().getSimpleName());
        if (element != null) {
            descriptionBuilder.append(String.format(" (@%s:%s:%s)", element.getClassName(), element.getMethodName(), element.getLineNumber()));
        }

        if (threadName != null) {
            descriptionBuilder.append(String.format(" {%s}", threadName));
        }

        return descriptionBuilder.toString();
    }

}