# Тестовое задание CaseLab Java
***
## 1. Описание решения:
### Стек технологий:
* Java 17, Spring Boot
* Взаимодействие с API через JSON
* СУБД PostgreSQL 16
* Spring Data
* JUnit и Mockito для написания юнит-тестов
* Контейнеризация при помощи Docker

## 2. Инструкция по запуску
1. Склонировать репозиторий
2. Создать базу данных с названием GreenAtom
3. Выполнить maven:clean, maven:install
4. В терминале ввести: docker-compose up -d
5. Ввести запросы в Postman

## 3. Примеры запросов

### Создание файла (http://localhost:8081/api/greenatom/storage/create)
{
"file_data": "Zmlyc3RmaWxl",
"title": "first file",
"creation_date": "2024-08-16 17:10:00",
"description": "description of first file"
}

{
"file_data": "c2Vjb25kZmlsZQ==",
"title": "second file",
"creation_date": "2024-08-16 14:10:00",
"description": "description of second file"
}

{
"file_data": "dGhpcmRmaWxl",
"title": "third file",
"creation_date": "2024-08-16 18:34:00",
"description": "description of third file"
}

{
"file_data": "Zm91cnRoZmlsZQ==",
"title": "first file",
"creation_date": "2024-08-16 16:41:00",
"description": "description of fourth file"
}

### Получение файла (http://localhost:8081/api/greenatom/storage/get/file?id=1)
* ID является параметром API

### Получение файлов (http://localhost:8081/api/greenatom/storage/get?num=0&size=3)
* Номер страницы и количество записей на странице - параметры API
* Параметр для номера страницы - num, для количества записей - size
* Файлы выводятся по увеличению даты и времени


