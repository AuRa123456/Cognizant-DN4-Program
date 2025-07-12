package com.cognizant.springlearn.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class DatePropertyEditorRegistrar implements PropertyEditorRegistrar {

    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        registry.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }
}