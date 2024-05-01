# Stack:
  - Kotlin
  - MVVM + Clean Architecture
  - Coroutines+Flow
  - Retrofit+OKHHTP
  - Navigation components + custom argument delegate
  - HILT
  - ROOM
  - Glide
  - Timber

## Done
Многомудльный проект (в связи с тем, что проект не большой, разделение на модули Data, Domain, Presentation, а не использование фича-модулей). 
Реализован поиск по пользователям: в ветке мастер оставлен не реактивный вариант поиска, плюс отключена пагинация списка пользователей (показывается первые 100 результатов поиска. 
сделано это в первую очередь из-за рейтлимитов для неавторизованных пользователей). Также для пользователя, идёт подсчёт кол-во подписчиков, если их больше 100, отображается соответствующее значение. 
Переход на детальную информацию, отображается логин и аватар пользователя, а также информация по первым 100 репозиториям пользователя.

## TODO
  - авторизация для обхода рейтлимитов
  - поддержка другого функционала api
  - миграция на gradle version catalog
  - полноценная пагинация (возможно с paging 3)
  - ui kit
  - unit/ui тесты
