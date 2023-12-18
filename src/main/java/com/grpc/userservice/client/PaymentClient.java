package com.grpc.userservice.client;

import grpc.userservice.PaymentServiceGrpc;
import grpc.userservice.PaymentServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class PaymentClient {
    private final ManagedChannel channel;

    private final PaymentServiceGrpc.PaymentServiceBlockingStub blockingStub;

    public PaymentClient(@Value("${grpc.server.host}") String host,
                         @Value("${grpc.server.port}") int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = PaymentServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown()  {
        try{
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }catch(InterruptedException e){
            //TODO handle et
            throw new RuntimeException("Failed to shutdown gRPC client", e);
        }
    }
    public PaymentServiceOuterClass.PaymentDto pay(PaymentServiceOuterClass.CreatePayment createPayment){
        return blockingStub.pay(createPayment);
        //TODO Error handling yap, StatusRuntimeException
    }
}
