package com.saranganrajan.apps.coredomainpublisher.publisher;

import org.springframework.stereotype.Service;


public interface MessagePublishAdapter {
    <T> void publish(T message, String label);
}
