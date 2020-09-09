package com.ework.upms.server.i18n;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

public class I18nTest {
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;

//    public ReloadableResourceBundleMessageSource getReloadableResourceBundleMessageSource() {
//        return reloadableResourceBundleMessageSource;
//    }

    public void setReloadableResourceBundleMessageSource(ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource) {
        this.reloadableResourceBundleMessageSource = reloadableResourceBundleMessageSource;
    }

    public String getMessage(String code, Object[] args, Locale locale) {
        return this.reloadableResourceBundleMessageSource.getMessage(code, args, locale);
    }
}
