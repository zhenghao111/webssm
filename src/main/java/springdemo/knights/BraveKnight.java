package springdemo.knights;

import lombok.*;

public class BraveKnight implements Knight{

    @Getter @Setter
    private Quest quest;


    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
