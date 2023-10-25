package com.delazeri.cleanarch.infrastructure.controllers.responses;

public record Response<T>(T data, boolean success) {
}
