require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: hello
        intent!: /привет
        a: Привет!

    state: Bye
        intent!: /пока
        a: Пока!

    state: NoMatch
        intent!: /NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}
        
    state: weather
        intent!: /погода
        q!: * (~погода|~дождь|~солнце|~гроза|~ветер) *
        a: Сегодня будет солнечная погода! 
        
    state: currency
        intent!: /курс валют
        q!: * (~курс|~валюта|~доллар|~рубль|~обмен) *
        a: Доллар стоит 80.54 рублей

    state: Match
        event!: match
        a: {{$context.intent.answer}}