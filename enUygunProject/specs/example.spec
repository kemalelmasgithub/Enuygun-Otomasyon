Getting Started with Gauge
==========================

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.
To execute this specification, use `mvn test`

İstanbul'dan Ankara'ya Gidiş Dönüş Uçuş Arama
--------------------
Tags:İstanbul-Ankara, Gidis-Dönüs, Ucak Bileti
*"2" saniye bekle
*"//div[@data-testid='search-round-trip-text']" xpath'li elemente tıkla
*"2" saniye bekle
*"//div[@data-testid='flight-origin-label']" xpath'li elemente tıkla
*"2" saniye bekle
*"//input[@data-testid='endesign-flight-origin-autosuggestion-input']" xpath'li elemente kalkış bilgisi icin "İstanbul" değerini yaz
*"2" saniye bekle
*"//div[@data-testid='autosuggestion-custom-item-istanbul-sabiha-gokcen-havalimani']" xpath'li elemente tıkla
*"2" saniye bekle
*"//label[@data-testid='flight-destination-input-comp']" xpath'li elemente tıkla
*"2" saniye bekle
*"//input[@data-testid='endesign-flight-destination-autosuggestion-input']" xpath'li elemente inis bilgisi icin "Ankara" değerini yaz
*"2" saniye bekle
*"//div[@data-testid='autosuggestion-custom-item-ankara-esenboga-havalimani']" xpath'li elemente tıkla
*"2" saniye bekle
*"//label[@data-testid='enuygun-homepage-flight-departureDate-input-comp']" xpath'li elemente tıkla
*"2" saniye bekle
*"//button[@title='2024-10-14']" xpath'li elemente tıkla
*"2" saniye bekle
*"//label[@data-testid='enuygun-homepage-flight-returnDate-input-comp']" xpath'li elemente tıkla
*"2" saniye bekle
*"//button[@title='2024-10-21']" xpath'li elemente tıkla
*"2" saniye bekle
*"//button[@data-testid='enuygun-homepage-flight-submitButton']" xpath'li elemente tıkla
*"15" saniye bekle
*"//i[@class='ctx-filter-departure-return-time ei-expand-more ']" xpath'li elemente tıkla
*"2" saniye bekle
*slider'ı "10":00 ve "18":00 için ayarla
*"5" saniye bekle







