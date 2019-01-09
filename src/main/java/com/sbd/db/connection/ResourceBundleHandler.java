package com.sbd.db.connection;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleHandler 
{
	private static final String BUNDLE_NAME = "utils"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ResourceBundleHandler() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return null;
		}
	}
}
