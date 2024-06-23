package com.osharedesigns.oshare_store.model.dto.request;

public record dtoProduct_read(String name) {

    public String getName(){
        return name;
    }
}
