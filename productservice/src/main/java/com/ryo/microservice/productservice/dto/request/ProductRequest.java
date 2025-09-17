package com.ryo.microservice.productservice.dto.request;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal price) {
}
