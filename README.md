# HolyLightDecorMod
Special for CraftOut

В релизах лежит скомпилированный мод. Для обновления мода, удалить прошлую папку java из мода, вставить новую. По возможности переписать конфиг файл под апдейты.

# Описание конфиг файла ->

Пример:
{

name: "Генератор"; / Имя регестрируемого блока

model_path: "models/decor/Generator.obj"; / Путь к модели

texture_path: "models/decor/textures/Generator.png"; / Путь к текстуре для модели

{Новое в 1.15}
icons: "generator"; / Имя файла иконки по пути -> assets\decor-mod\textures\blocks. Записывать без .png

{Новое в 1.15}
light: "1"; / От 1-15 Чем больше число тем сильнее освещение. (При 0 не излучает свет)
/ Записывать только целые числа. [3] - Можно [3.12] - Нельзя 

{Новое в 1.15}
creativeTab: "2"; / Вкладка в креативе (Пока что от 1-5) 

collide: true; / Коллизия блока true/false

}
