package CarmineGargiulo.FS0624_Unit5_Week1_Day4.services;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.MenuProduct;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.repositories.MenuProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuProductsService {
    @Autowired
    private MenuProductsRepository menuProductsRepository;

    public void saveProduct(MenuProduct menuProduct){
        menuProductsRepository.save(menuProduct);
        System.out.println("Product " + menuProduct.getName() + " has been saved correctly");
    }

    public void saveManyProduct(List<MenuProduct> menuProducts){
        for (MenuProduct product : menuProducts){
            this.saveProduct(product);
        }
    }

    public long count(){
        return menuProductsRepository.count();
    }
}
