# custom-serialization-format-example
An example of custom Externalizable interface which uses JSON and zip for Serialization of its implementations.

Пример работы программы:
```
Объект был конвертирован в JSON:
	{"one":"1","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{"msg1":{"one":"12","msg2":{"two":"2","msg3":{}}}}}}}}}}}}}}}}}}
длинной 280 символа
Объект был сжат в последовательность байт:
7ŵ  PK-'�)-     PK ��TL-'�)-                     Message1PK      6   c     
длинной 175 символа
Оригинальный объект:	Message1{one='1', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=null}}}}}}}}}}}}}}}}}}
Восстановленный объект:	Message1{one='1', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=Message1{one='12', msg2=Message2{two='2', msg3=Message3{three='null', msg1=null}}}}}}}}}}}}}}}}}}
Disconnected from the target VM, address: '127.0.0.1:57044', transport: 'socket'
```
