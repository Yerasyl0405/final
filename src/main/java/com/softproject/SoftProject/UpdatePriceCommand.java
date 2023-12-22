package com.softproject.SoftProject;
public class UpdatePriceCommand implements Command {
    private ProductService productService;
    private Long productId;
    private double newPrice;

    public UpdatePriceCommand(ProductService productService, Long productId, double newPrice) {
        this.productService = productService;
        this.productId = productId;
        this.newPrice = newPrice;
    }

    @Override
    public void execute() {
        productService.updateProductPrice(productId, newPrice);
    }
}


