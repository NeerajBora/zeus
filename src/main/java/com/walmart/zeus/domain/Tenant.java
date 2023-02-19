package com.walmart.zeus.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tenant")
public class Tenant {
    @Id
    private String _id;
    private String app;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tenant{");
        sb.append("_id='").append(_id).append('\'');
        sb.append(", app='").append(app).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
