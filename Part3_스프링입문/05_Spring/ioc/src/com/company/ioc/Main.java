package com.company.ioc;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base 64 encoding

        // url encoding

        // new Encoder의 파라미터를 통해 외부에서 사용하는 객체를 주입받음 => DI
        //Encoder encoder = new Encoder(new Base64Encoder());
        Encoder encoder = new Encoder(new UrlEncoder());

        String result = encoder.encode(url);
        System.out.println(result);
    }
}
