package CarmineGargiulo.FS0624_Unit5_Week1_Day4.services;

import CarmineGargiulo.FS0624_Unit5_Week1_Day4.entities.Table;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.exceptions.NotFoundException;
import CarmineGargiulo.FS0624_Unit5_Week1_Day4.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesService {
    @Autowired
    private TablesRepository tablesRepository;

    public void saveTable(Table table){
        tablesRepository.save(table);
        System.out.println("Table number " + table.getTableNr() + " saved correctly ");
    }

    public void saveManyTable(List<Table> tableList){
        for (Table table : tableList) this.saveTable(table);
    }

    public List<Table> findAllTables(){
        return tablesRepository.findAll();
    }

    public Table findTableByNr(long nr){
        return tablesRepository.findById(nr).orElseThrow(()-> new NotFoundException(nr));
    }

    public long countTables(){
        return tablesRepository.count();
    }
}
