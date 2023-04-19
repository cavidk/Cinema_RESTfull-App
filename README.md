# Cinema_RESTfull-App

Kinoteatr - RESTful Application
Yazılacaq tətbiq Spring Boot -da olmalıdır və Java dilində yazılmalıdır
Yazılacaq tətbiq OOP, KİSS, DRY, APO, YAGNİ və digər prinsiplərə uyğun olmalıdır.
Məlumatlar verilənlər bazasında saxlanılmalıdır. Baza olaraq H2 istifadə edin.<br>
❗ Əgər Strong Junior, Middle və ya Senior səviyyəsinə iddialısınızsa
bazanı qurmazdan öncə UML-dən istifadə edin.<br>
Layihəni test edə bilmək üçün demo məlumatlar daxil edilməlidir. (məs.
CommandLineRunner vasitəsi ilə)<br>
❗ Əgər Strong Junior, Middle və ya Senior səviyyəsinə iddialısınızsa:
demo məlumatların əlavə edilməsini db migration ilə realizə edin
(flyway və ya liquibase)<br>
Yazılmış tətbiqi test edə bilmək üçün Swagger UI əlavə edilməlidir ( springfox və
ya springdoc ).<br>
Layihəni test edə bilmək üçün bir neçə istifadəçi əlavə edin.
Namizədlər üçün test tapşırıq 2<br>
❗ Əgər Strong Junior, Middle və ya Senior səviyyəsinə iddialısınızsa:
istifadəçinin qeydiyyatı funksionallığını realizə edin. İstifadəçi adı
və şifrə ilə jwt əldə etmək imkanı olmalıdır. AccessToken vaxtı
bitdiyi halda refreshToken vasitəsi ilə yeni jwt əldə etmək imkanı
olmalıdır.<br>
  Swagger-də test üçün security sazlanmalıdır. Bunun üçün Spring
Security qoşmağınız gərəkdir.
İstifadəçidən qeydiyyat zamanı əldə ediləcək məlumatlar SAA,
istifadəçi adı və şifrə
Daxil edilmiş məlumat səhvdirsə müvafiq mesaj göstərilməlidir.
Tətbiqin işlədiyi zamanı baş verə biləcək istisnalar nəzərə alınmalıdır. İstisna
hallarını düzgün şəkildə handle etməyiniz gərəkdir.
Ən azı qeyd edilmiş entity-ləri əlavə edin. Ticket (bilet), Session (seans), Movie
(film), Hall (zal) Seat (oturacaq), User (istifadəçi) - adlar fərqlənə bilər. Entity-lər
arası əlaqələri qurun.
❗ Relation-lar üçün fetchType.LAZY təyin edin və
LazyİnitializationException istisnasının qarşısını alın

>> Kinoteatrda qeyd edilmiş entity-lər üzrə CRUD əməliyyatlar olmalıdır.<br>
|<>| Məsələn, kinoteatra yeni film əlavə etmək imkanı, əlavə edilmiş filmi redaktə
etmək imkanı.<br>
>> Filmlər üzrə axtarış etmək imkanı olmalıdır.<br>
>> Hər bir film üçün bilet əlavə etmək imkanı. Filmlər müxtəlif seanslarda
göstərilə bilər.<br>
 ::Məsələn, səhər və axşam. Bunun üçün seans əlavə etmək
imkanı olmalıdır.<br>
 Müxtəlif zallarda müxtəlif filmlər göstərilə bilər. Hər biz zalda oturacaq sayı
məhduddur. Məsələn, 30.<br>
 
 Namizədlər üçün test tapşırıq 3
<h1> - OSİV antipattern-ni söndürün və yaranacaq problemləri həll edin.</h1>
<h1> - Tətbiqdə biletin CRUD əməliyyatlardan əlavə olaraq alış-satış funksionallığını realizə edin.</h1>

  ::Process::
>> İstifadəçinin balansı olmalıdır. Hər bir yeni qeydiyyatdan keçmiş
>> istifadəçinin balansı 100 AZN bərabər olmalıdır.
>> İstifadəçi filmlərin siyahısını görməlidir. Filmi seçdikdən sonra
seanslar göstərilməlidir. Olacaq seanslar – səhər, axşam. Səhər
və axşam seanslarının qiyməti fərqli ola bilər. Məsələn, 11.35 AZN
səhər seansı üçün və 13.75 AZN axşam seansı üçün.

>> İstifadəçi istədiyi bileti qaytara bilər.
>> İstifadəçi bilet əldə etdiyi və yaxut qaytardığı zaman onun balansı
yenilənməlidir.
>> Ümumi olaraq 3 zal olacaq. Hər bir zalın oturacaq sayı – 30.
Oturacaq sayı həmin seans üçün çox olarsa bilet satışı
dayandırılmalıdır. Hər bir seans üçün 90 (3x30) bilet ola bilər.
Kinoteatr üçün müvafiq service, controller və DAO qatları yazmalısınız. DTO
pattern-ni realizə etməlisiniz <br>
❗ Spring HATEOAS kitabxanasını qoşun.<br>
❗ Unit test əlavə edin<br>
Namizədlər üçün test tapşırıq 4 <br>
❗ Docker və docker compose üçün konfiqurasiyaları əlavə edin.
