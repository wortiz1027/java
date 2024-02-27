package org.workshop.starter.service;

import org.workshop.starter.objects.Message;

public interface IClientEncoder {

    String communicate(Message message);

}