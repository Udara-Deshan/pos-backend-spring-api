package lk.ijse.posBackEnd.service.impl;

import lk.ijse.posBackEnd.dto.ItemDTO;
import lk.ijse.posBackEnd.entity.Item;
import lk.ijse.posBackEnd.repo.ItemRepo;
import lk.ijse.posBackEnd.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public String saveItem(ItemDTO dto) {
        if (!repo.existsById(dto.getItemID())) {
            Item item = mapper.map(dto, Item.class);
            repo.save(item);
            return "Item saved Successfully..!";
        } else {
            return "Item already exist..!";
        }
    }

    @Override
    public String updateItem(ItemDTO dto) {
        if (repo.existsById(dto.getItemID())) {
            Item item = mapper.map(dto, Item.class);
            repo.save(item);
            return "Item update Successfully..!";
        } else {
            return "No such item for update..!";
        }
    }

    @Override
    public ItemDTO searchItem(String id) {
        Optional<Item> item = repo.findById(id);
        if (item.isPresent()) {
            return mapper.map(item.get(), ItemDTO.class);
        } else {
            throw new RuntimeException("No item for id: " + id);
        }
    }

    @Override
    public String deleteItem(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Item deleted for ID: " + id;
        } else {
            return "No item for delete ID: " + id;
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<ItemDTO>>() {
        }.getType());
    }
}
