package ru.inbox.savinov_vu.model.goods.status;

enum EnumStatusProduct  {
    Обработан, Не_обработан, Отменен,
    Заказан, Не_заказан,
    Выявлен_дефект, Проверен_и_отложен, Отсутствует,
    Дозвон, Перезвонить, Не_Звонили,
    Выдан, Не_выдан;

/*
    @Transient
    @JsonProperty("group")
    private int group = 10;

    public int getGroup() {

        switch (this) {
            case Обработан:
            case Не_обработан:
            case Отменен:
                return  1;
               */
/* break;*//*

            case Заказан:
            case Не_заказан:
                return 2;
        */
/*        break;*//*

            case Выявлен_дефект:
            case Проверен_и_отложен:
            case Отсутствует:
                return 3;
               */
/* break;*//*

            case Дозвон:
            case Перезвонить:
            case Не_Звонили:

                return  4;
            */
/*break;*//*

            case Выдан:
            case Не_выдан:
                return  5;
          */
/*  break;*//*

        }
        return 0;
    }

    public void setGroup(int group) {
        this.group = group;
    }
*/



}
