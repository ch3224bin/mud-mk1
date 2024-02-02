package com.jefflife.gameserver.item.adapter.out.persistence;

import com.jefflife.gameserver.item.adapter.out.persistence.entity.ItemEntity;
import com.jefflife.gameserver.item.application.domain.model.Item;
import com.jefflife.gameserver.item.application.port.out.LoadItemPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadItemAdapter implements LoadItemPort {
    private final ItemRepository itemRepository;

    public LoadItemAdapter(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findByName(String name) {
        return itemRepository.findByNameLike(name)
                .stream()
                .map(ItemEntity::toDomain)
                .toList();
    }
}
