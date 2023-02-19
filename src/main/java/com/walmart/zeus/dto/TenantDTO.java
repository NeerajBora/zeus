package com.walmart.zeus.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class TenantDTO {
    private String app;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TenantDTO{");
        sb.append("app='").append(app).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
