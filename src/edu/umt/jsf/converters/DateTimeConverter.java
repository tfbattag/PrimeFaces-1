/*
 * Copyright (c) 2013. All rights reserved.
 */

package edu.umt.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 7/25/13
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */

public class DateTimeConverter implements Converter {
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
        if (arg2 == null || arg2.length() == 0) {
            return null;
        }
        try {
            Date timeAsDate = sdf.parse(arg2);
            return new Time(timeAsDate.getTime());
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return null;
    }

    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
        if (arg2 != null) {
            return sdf.format(arg2);
        } else {
            return "";
        }

    }

}
