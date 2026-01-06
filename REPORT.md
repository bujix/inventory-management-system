# Envanter Yönetim Sistemi – Proje Raporu

## 1. Proje Tanımı
Bu projede, ürünlerin, stok seviyelerinin ve siparişlerin yönetildiği
nesne tabanlı bir Envanter Yönetim Sistemi geliştirilmiştir.

Proje Java dili kullanılarak geliştirilmiş olup,
nesne tabanlı programlama prensiplerini uygulamayı hedeflemektedir.

---

## 2. Nesne Tabanlı Programlama Yaklaşımı

Projede aşağıdaki nesne tabanlı programlama prensipleri uygulanmıştır:

### 2.1 Encapsulation (Kapsülleme)
Product sınıfında alanlar private olarak tanımlanmış, verilere
getter ve setter metotları aracılığıyla erişim sağlanmıştır.

### 2.2 Inheritance (Kalıtım)
PerishableProduct sınıfı, Product sınıfından kalıtım alarak
bozulabilir ürünler için son kullanma tarihi özelliği eklemiştir.

### 2.3 Interface Kullanımı
Storable interface’i ile stok yönetimi davranışı soyutlanmış
ve Product sınıfı bu interface’i implemente etmiştir.

### 2.4 Composition (Bileşim)
Inventory sınıfı, Product ve Order sınıflarını composition yoluyla
kullanarak envanter ve sipariş yönetimini gerçekleştirmektedir.

---

## 3. İş Kuralları (Business Logic)

Stok ile ilgili iş kuralları StockManager sınıfında toplanmıştır.
Bu sayede iş kuralları model sınıflarından ayrılmış ve
Single Responsibility Principle uygulanmıştır.

---

## 4. Unit Testler

StockManager sınıfı için JUnit kullanılarak birim testler yazılmıştır.
Bu testlerde stok artırma ve azaltma senaryoları doğrulanmıştır.

---

## 5. UML Diyagramları

Projede aşağıdaki UML diyagramları hazırlanmıştır:

- Sınıf Diyagramı (Class Diagram)
- Use-Case Diyagramı

Diyagramlar `uml` klasörü altında dokümante edilmiştir.

---

## 6. Proje Yönetimi (Git & Kanban)

Proje sürecinde Git ve Github kullanılmıştır.
Geliştirme süreci boyunca anlamlı commit mesajları ile
versiyon kontrolü sağlanmıştır.

Görev takibi için Github Projects üzerinde Kanban board kullanılmıştır.

---

## 7. Demo ve Uygulamanın Çalıştırılması

Demo sırasında uygulama kendi bilgisayarım üzerinde çalıştırılmıştır.
Proje yapısı ve sınıflar incelenmiş, stok yönetimi ve iş kuralları
kod üzerinden gösterilmiştir.

StockManager sınıfı üzerinden stok artırma ve azaltma işlemleri
açıklanmış, Inventory sınıfının ürün ve sipariş yönetimi
nasıl yaptığı anlatılmıştır.

Ayrıca JUnit test sınıfları gösterilerek
stok işlemlerinin test edildiği belirtilmiştir.
