package com.zhenghao.knights;

import lombok.Getter;
import lombok.Setter;

public class BraveKnight implements Knight{

    @Getter
    @Setter
    private Quest quest;


    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
