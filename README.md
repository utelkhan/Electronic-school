
# Electronic-school


## 1. Скачивание
   Чтобы скачать проект, запустите команду `git clone https://github.com/UtelkhanAzamat/Electronic-school.git` в консоли, в удобной вам директории.
   
   
## 2. Настройка
   После скачивания, нужно настроить несколько вещей перед запуском приложения.
   
### 2.1  Настройка базы данных.
   В файле *application.properties* нужно прописать ващи настройки базы данных.
###### Открываем файл конфигурации application.properties
1. Измените название базы данных(если у вас другой порт,указажите его).
2. Измените имя пользователя, с которым вы входите в базу данных.
3. Измените пароль от базы данных.
4. Чтобы инициализировать или повторно извлечь тестовые данные, установите значение на true (после первого запуска можно установить на false).
![db](https://github.com/UtelkhanAzamat/Electronic-school/blob/main/db.bmp)

### 2.2  Настройка клиентской части приложения.
   Установка необходимых модулей.
###### Перейдите в каталог с клиентской стороны приложения
1. Откройте командную строку.
2. И затем выполните команду `npm install`, которая установит все необходимые модули.


## 3. Запуск
###### Запускаем server и client по отдельности:
1. Запустите джава приложение.
2. Запустите команду `npm start` на клиентской сторонe приложения.
3. Затем заходим в браузер по адресу: http://localhost:4200/
4. После вы можете зайти на сайт, с одним из этих данных:
   - username: user, password: user
   - username: azamat, password: azamat
   - username: greetgo, password: greetgo
5. Дальше вы проходите на главную страницу, где есть таблица студентов. Вы можете создать студента и удалить.
