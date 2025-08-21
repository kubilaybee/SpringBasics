# **Anotasyonlar**

### `@Bean`

- **Görevi:** Bir metodun döndürdüğü nesneyi Spring Bean olarak tanımlar.
- **Kullanımı:** `@Configuration` sınıfının içindeki metodların üzerinde kullanılır. Metodun geri dönüş değeri, bir bean olarak yönetilir.

---

### `@Configuration`

- **Görevi:** Bir sınıfın, Spring'in bean tanımlamaları ve ayarları için kullandığı bir yapılandırma sınıfı olduğunu belirtir.
- **Kullanımı:** `@Bean` metotlarını barındıran sınıfların üzerinde kullanılır. Spring'in IoC konteyneri bu sınıfları tarar.

---

### `@Primary`

- **Görevi:** Aynı türden birden fazla bean olduğunda, varsayılan olarak hangi bean'in seçileceğini belirtir.
- **Kullanımı:** `@Bean` veya `@Component` gibi bean tanımlama anotasyonlarının üzerinde kullanılır.

---

### `@Qualifier`

- **Görevi:** Bağımlılık enjeksiyonu sırasında, hangi belirli bean'in isme göre kullanılacağını kesin olarak belirtir.
- **Kullanımı:** `@Autowired` gibi enjeksiyon anotasyonlarıyla birlikte kullanılır.

---

### `@Component`

- **Görevi:** Bir sınıfın genel amaçlı bir Spring Bean olduğunu belirtir.
- **Kullanımı:** Sınıfın üzerinde kullanılır. Spring'in `@ComponentScan` özelliği bu sınıfları otomatik olarak bulup bean yapar. `@Service`, `@Repository` ve `@Controller` gibi anotasyonlar, `@Component`'in daha özel halleridir.

---

### `@ComponentScan("modulePath")`

- **Görevi:** Belirtilen paket ve alt paketleri tarayarak `@Component` türevi anotasyonlara sahip sınıfları bulur ve onları Spring Bean olarak kaydeder.
- **Kullanımı:** `@SpringBootApplication` zaten bunu varsayılan olarak yaptığı için, genellikle farklı paketlerdeki bean'leri eklemek gerektiğinde kullanılır.

---

### `@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)`

- **Görevi:** Bir bean'in yaşam döngüsünün kapsamını belirler. En sık kullanılan iki kapsam `singleton` ve `prototype`'dır.
- **Kullanımı:** Bean tanımlama anotasyonlarının (`@Component`, `@Bean`) üzerinde kullanılır.

---

### `@Lazy`

- **Görevi:** Bir bean'in, uygulama başlangıcında değil, ilk kez ihtiyaç duyulduğunda oluşturulacağını belirtir. Bu, uygulama başlatma süresini kısaltmaya yardımcı olabilir.
- **Kullanımı:** `@Bean`, `@Component` veya `@Autowired` gibi bağımlılık tanımlama noktalarında kullanılır.

---

### `@Eager`

- **Görevi:** Normalde tembel (lazy) olan bir bean'in, uygulama başlangıcında hemen oluşturulmasını sağlar. Genellikle `@Lazy`'nin zıttı bir etki yaratmak için kullanılır. Spring'in varsayılan bean davranışı zaten heveslidir (eager).
- **Kullanımı:** Bu özel bir anotasyon değildir, daha çok konsepttir. `spring.main.lazy-initialization=true` ayarı ile tüm bean'ler tembel yapılırsa, belirli bir bean'in hevesli olmasını sağlamak için doğrudan `@Lazy` kullanılmaz, ancak bu konseptin tersi olarak bilinir.

---

### `@Named`

- **Görevi:** Bir sınıfı CDI'ın yönettiği bir bean olarak tanımlar. Spring'de kullanılan `@Component` anotasyonunun CDI standardındaki karşılığıdır. `@ComponentScan`'in taraması sonucunda Spring, `@Named` ile işaretlenmiş sınıfları tanır ve onları bir Spring bean'i olarak konteynerine kaydeder.
- **Kullanımı:** Doğrudan bir sınıfın üzerinde kullanılır.

---

### `@Injec`

- **Görevi:** Bağımlılık enjeksiyonunu gerçekleştirmek için kullanılır. Bu anotasyon, Spring'in `@Autowired` anotasyonu ile benzer bir işlevi yerine getirir. Spring, `@Inject` anotasyonunu gördüğünde, ihtiyaç duyulan bağımlılığı (bean'i) IoC konteynerinden bulur ve hedeflenen alana, yapıcı metoda veya ayarlayıcı metoda (setter) enjekte eder.
- **Kullanımı:** Yapıcı metotların (constructor), alanların (field) veya ayarlayıcı metotların (setter) üzerinde kullanılabilir. Sağladığınız kod örneğinde, `setDataService` metodu üzerinde kullanılarak **Setter Injection** yapılmıştır.

# **Terimler**

### Tight Coupling (Sıkı Bağlılık)

- **Tanımı:** Bir sınıfın, bağımlı olduğu diğer sınıflara doğrudan bağlı olması durumudur. Bu, bir sınıfta yapılan değişikliğin, ona bağlı diğer sınıfları da etkilemesi anlamına gelir. DI prensibi bunun önüne geçmeyi amaçlar.

---

### Loose Coupling (Gevşek Bağlılık)

- **Tanımı:** Bir sınıfın, bağımlı olduğu diğer sınıflara soyut bir şekilde bağlı olması durumudur. Bu, bağımlı olunan sınıfın değişmesinin, bağımlı olan sınıfı doğrudan etkilemediği anlamına gelir. Spring'in DI mekanizması bunu sağlar.

---

### Java Bean

- **Tanımı:** Java dilinin belirlediği, varsayılan yapıcı metot, özel alanlar ve genel erişim metotları (getter/setter) gibi kurallara uyan bir sınıftır.
- **Yönetimi:** Geliştirici tarafından oluşturulur. Spring'den bağımsız bir kavramdır.

---

### Spring Bean

- **Tanımı:** Spring'in IoC konteyneri tarafından yaşam döngüsü boyunca yönetilen herhangi bir nesnedir.
- **Yönetimi:** Spring Container tarafından yönetilir ve Spring'in sunduğu tüm özelliklerden faydalanabilir. Her Spring Bean bir Java Bean olabilir, ancak her Java Bean bir Spring Bean değildir.

---

### IoC (Inversion of Control)

- **Tanımı:** Kontrolün tersine çevrilmesi anlamına gelir. Nesnelerin oluşturulması ve bağımlılıklarının yönetilmesi kontrolünü geliştiriciden alıp bir konteynere (Spring Container) devreden bir yazılım prensibidir.

---

### IoC Container (Kontrolü Tersine Çevirme Konteyneri)

**Tanımı:** Nesnelerin oluşturulması, yaşam döngüsünün yönetilmesi ve bağımlılıklarının enjekte edilmesi gibi görevleri üstlenen bir yazılım çerçevesi bileşenidir. Bu, kontrolü, kodun kendisinden alıp, bu konteynere devrederek merkezi bir yönetim sağlar.

**Kullanım Amacı:**

- Sınıflar arasındaki bağımlılıkları azaltarak gevşek bağlılığı (Loose Coupling) teşvik eder.
- Uygulama bileşenlerinin yönetimini basitleştirir.
- Kodun test edilebilirliğini ve esnekliğini artırır.

---

### Spring Container / Application Context

- **Tanımı:** Spring'in IoC prensibini uyguladığı temel bileşendir. Bean'leri oluşturur, konfigüre eder, yönetir ve bağımlılıklarını sağlar. `ApplicationContext`, en yaygın kullanılan Spring Container türüdür.

---

### Spring Container, Spring Application Context ve IoC Container

Bu üç terim genellikle aynı şeyi ifade etmek için kullanılır ancak aralarında teknik olarak küçük farklar vardır:

- **IoC Container (Genel Kavram):** Bu, herhangi bir yazılım çerçevesinde "Kontrolün Tersine Çevrilmesi" prensibini uygulayan soyut bir kavramdır. Spring bu prensibi kendi konteyneri ile uygular.
- **Spring Container:** Spring Framework'ün kendi IoC Container'ına verdiği genel isimdir. Spring Container, bean'leri oluşturur, konfigüre eder ve bağımlılıklarını yönetir.
- **Application Context:** Bu, `org.springframework.context.ApplicationContext` arayüzü ile temsil edilen en yaygın kullanılan Spring Container türüdür. `ApplicationContext`, IoC Container'ın yanı sıra, olay yönetimi, kaynak yükleme ve uluslararasılaşma (i18n) gibi daha gelişmiş özellikler de sunar.

**Özetle,** "IoC Container" genel bir prensiptir. "Spring Container" bu prensibin Spring'deki somutlaşmış halidir. "Application Context" ise bu Spring Container'ının, genellikle kullanılan, zengin özelliklere sahip bir implementasyonudur. Dolayısıyla, pratik kullanımda ve çoğu durumda, bu terimler birbiri yerine kullanılabilir.

---

### Dependency

- **Tanımı:** Bir nesnenin, ihtiyaç duyduğu bağımlılıkları kendisinin oluşturması yerine, bu bağımlılıkların bir dış kaynak (genellikle bir IoC konteyneri) tarafından kendisine sağlanması prensibidir.
- **Kullanım Amacı:** Bu yöntem, sınıflar arasındaki sıkı bağlılığı (Tight Coupling) azaltarak gevşek bağlılığı (Loose Coupling) teşvik eder. Bu sayede, kodun daha esnek, yeniden kullanılabilir ve özellikle birim testlerinin daha kolay yazılabilir olmasını sağlar.

---

### Dependency Injection (DI)

- **Tanımı:** Bir nesnenin, ihtiyaç duyduğu bağımlılıkları doğrudan kendisinin oluşturması yerine, dışarıdan (Spring Container tarafından) sağlanması prensibidir.
- **Kullanım Amacı:** Bağımlılıkları bir sınıftan soyutlayarak **Loose Coupling** (gevşek bağlılık) sağlar ve kodun daha kolay test edilebilir olmasını sağlar.

---

### Dependency Injection Types (Bağımlılık Enjeksiyon Türleri)

1. **Constructor Injection:** Bağımlılıklar, sınıfın yapıcı metodu (constructor) aracılığıyla sağlanır. **En çok tavsiye edilen yöntemdir.**
2. **Setter Injection:** Bağımlılıklar, sınıfın `setter` metotları aracılığıyla enjekte edilir.
3. **Field Injection:** Bağımlılıklar, alan (field) üzerine `@Autowired` anotasyonu konularak doğrudan enjekte edilir.

---

### Auto-wiring

- **Tanımı:** Spring'in, bir nesnenin bağımlılıklarını otomatik olarak bulup enjekte ettiği mekanizmadır. Geliştiricinin bağımlılıkları manuel olarak bağlamasını engeller. En sık `@Autowired` anotasyonu ile uygulanır.

---

### CDI (Contexts and Dependency Injection)

**CDI** bir Java EE (günümüzde Jakarta EE) standardıdır. Amacı, bağımlılık enjeksiyonunu kullanarak gevşek bağlı (loosely coupled) ve yeniden kullanılabilir bileşenler oluşturmayı kolaylaştırmaktır. Spring Framework, CDI'ı destekleyerek bu standardın anotasyonlarının kendi konteynerinde kullanılmasını sağlar.
