# application client for [gRPS](https://grpc.io/)

#### **В проекте используется:**   
* Логгирование
  * [slf4j](https://www.slf4j.org/)  
  * [logback](https://logback.qos.ch/)
* Тестирование
  * [junit5](https://junit.org/junit5/)
* [gRPS](https://grpc.io/)   


  
 --- 

#### **Консоль `gragle`**
Сгенерировать новые proto классы (предыдущая директория будет удалена) 
`src/main/grpc` 
важно - build в данном случае только для того, что бы получить новые java классы из proto файлов  
   
TODO исправить в рамках "улучшения разработки"  
Если билд упадет по любой причине, новые файлы grpc сгенерированные не будут, а старые уже будут удаленые   
!!! важно - при генерации proto -> jar еще не получает новых сгенерированных классов !!!    

`gradle build -Pgrpc`   
   

###### Собирает билд, умолчанию будет собран билд с внешними зависимостями   
`gradle build`   
   
   
###### Собирает билд без внешних зависимостей  
`gradle build -PwithoutExternalDependencies`   
   
   
###### Выводит названия выполняемых тасков в процессе сборки  
`-PshowNameTasks`   
*пример:*  
`gradle build -Pgrpc -PshowNameTasks`   
  
  

###### Запускает программу  
`java -jar build/libs/client-including-all-dependencies.jar`  

 
