# custom-serialization-format-example
An example of custom Externalizable interface which uses JSON and zip for Serialization of its implementations.

# Тестовое задание №3

В компании ОАО «Вешалки и Веснушки» существует распределенная система.
Компоненты системы обмениваются информацией используя Интернет. Протокол обмена HTTP\SOAP поверх TCP.

Компания не довольна текущим решением, т.к. офисы находятся в труднодоступных для широкополосного интернета местах. И, как следствие, стоимость трафика очень велика, а при передаче сообщений, используя SOAP и HTTP, размер сообщения увеличивается в разы.

Сами сообщения небольшие по объёму, но передаются очень часто, так как нужны актуальные данные в реальном времени.

Видов сообщений очень много и сотрудникам не хочется описывать формат для сериализации каждого из них вручную.

 
Было принято решение разработать собственную реализацию Сериализатора данных, удовлетворяющую следующим условиям:
 - Компактность результирующих данных сериализации.
 - Сериализация полного графа объекта.

Решение задачи должно содержать приложение, позволяющие наглядно просмотреть результат сериализации и десериализации данных. Реализация тестового приложения может быть выполнена с использованием любого типа графического приложения, т.е. можно использовать консольное приложение и полноценное GUI.

Запрещено использовать стандартные сериализаторы, к примеру BinaryFormatter, ObjectOutputStream и т.п.

# Пример работы программы:

```
Объект был конвертирован в JSON:
	{"one":"1","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{}}}}}}}}}}}}}}}}}}
длинной 280 символа
Объект был сжат в последовательность байт:
7ŵPK-'�)-PK��TL-'�)-Message1PK6c
длинной 175 символа
Оригинальный объект:	Message1{one='1', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=null}}}}}}}}}}}}}}}}}}
Восстановленный объект:	Message1{one='1', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=null}}}}}}}}}}}}}}}}}}
Disconnected from the target VM, address: '127.0.0.1:57044', transport: 'socket'
```
