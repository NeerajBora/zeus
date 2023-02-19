package com.walmart.zeus.dto;

import java.util.List;
import java.util.Map;

public class TaskDetailsDTO {
    private List<ButtonDTO> buttonsList;
    private Map<String , Object> details;

    public List<ButtonDTO> getButtonsList() {
        return buttonsList;
    }

    public void setButtonsList(List<ButtonDTO> buttonsList) {
        this.buttonsList = buttonsList;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TaskDetailsDTO{");
        sb.append("buttonsList=").append(buttonsList);
        sb.append(", details=").append(details);
        sb.append('}');
        return sb.toString();
    }
}
