package fr.yohann.bsim.messages;

import com.google.gson.annotations.Expose;
import fr.yohann.bsim.exceptions.ArgumentNotInitializedException;
import fr.yohann.bsim.types.ConnectorStatusEnumType;

import java.util.Date;

public record StatusNotificationRequest(@Expose Date dateTime, @Expose ConnectorStatusEnumType connectorStatus, @Expose int evseId, @Expose int connectorId) {

    public StatusNotificationRequest {
        if (dateTime == null) throw new ArgumentNotInitializedException("The dateTime in StatusNotificationRequest is null");

        if (connectorStatus == null) throw new ArgumentNotInitializedException("The connectorStatus in StatusNotificationRequest is null");
    }
}

