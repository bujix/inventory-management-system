package inventory.interfaces;

/**
 * Envanterde saklanabilen varlıkları temsil eden arayüz.
 * Stok miktarı yönetimi için gerekli metotları tanımlar.
 */
public interface Storable {

    /**
     * Mevcut stok miktarını döndürür.
     *
     * @return stok miktarı
     */
    int getStockQuantity();

    /**
     * Stok miktarını verilen değer kadar günceller.
     * Pozitif değer stok ekler, negatif değer stok düşer.
     *
     * @param amount eklenecek veya çıkarılacak miktar
     */
    void updateStock(int amount);
}
