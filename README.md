Эрдман Полина
polinaerdman@gmail.com

**Тестовый автоматизированный фреймворк для сайта бонусной системы банка PriorPlus**

**Структура проекта**

/src/main/java/by/plus/priorbank/ - содержит основной код страниц веб-приложения и утилитарный класс.
1. Пакет api:

   BaseApi - базовые настройки выполнения запросов

   UserLoginApiRequest - передача данных при отправке api-запросов

   UserLoginApiResponse - сообщения для выполнения проверок

2. Пакет ui (классы в проекте реализуют паттерн Page Object Model):

   2.1. driver с классом Driver - управляет взаимодействием с веб-драйвером

   2.2. pages

   2.2.1. login с классами LoginMessages, LoginPage, LoginXpath 

   2.2.2. search с классами SearchMessages, SearchPage, SearchXpath

   2.3. steps с классами LoginStep, SearchStep
   
3. Пакет utils
   
   User - содержит методы генерации данных пользователя

/src/test/java/by/plus/priorbank/ содержит тесты
1. Пакет api:
   
   BaseTest - содержит предварительные настройки запуска api-тестов
   
   LoginTest - содержит api тесты формы логина
   
2. Пакет ui:
   
   BaseTest - содержит предварительные настройки запуска и завершения ui-тестов
   
   LoginTest - содержит ui тесты формы логина
   
   SearchTest - содержит ui тесты функционала поиска по каталогу

**Реализованные проверки**

api login
   
   Авторизация c невалидными данными
   
   Авторизация c пустым email и password
   
   Авторизация c пустым email
   
   Авторизация c пустым password
   
ui login

   Авторизация c невалидными данными
   
   Авторизация c пустым email и password
   
   Авторизация c пустым email
   
   Авторизация c пустым password
  
ui search
  
  Открытие каталога
  
  Поиск продукта по названию
