class ProductOfNumbers {
    List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);  // Initial product set to 1
    }

    public void add(int num) {
        if (num == 0) {
            // Reset prefixProduct list when zero is added
            prefixProduct.clear();
            prefixProduct.add(1);
        } else {
            // Append the new product to the prefixProduct list
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int size = prefixProduct.size();
       if (k >= size) return 0;  // If k is greater than available elements
        return prefixProduct.get(size - 1) / prefixProduct.get(size - 1 - k);
    }
}
