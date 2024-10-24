package CarmineGargiulo.FS0624_Unit5_Week1_Day4.services;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.Menu;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.exceptions.NotFoundException;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public void saveMenu(Menu menu){
        menuRepository.save(menu);
        System.out.println("Menu saved correctly");
    }

    public long count(){
        return menuRepository.count();
    }

    public Menu getMenuById(long id){
        return menuRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
}
