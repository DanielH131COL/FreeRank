package koala.dev.freerank.commands;

import koala.dev.freerank.FreeRank;
import koala.dev.freerank.utils.FileConfig;

import java.util.ArrayList;

public class FreeRankAdmin {
    private ArrayList<String> claimedplayers = new ArrayList<>();

    private boolean canclaim = false;

    public void save() {
        FileConfig config = FreeRank.get().getMainConfig();
        config.getConfiguration().set("CLAIMED.PLAYERS", this.claimedplayers);
        config.getConfiguration().set("CAN-CLAIM", Boolean.valueOf(isClaimable()));
        config.save();
        config.reload();
    }

    public void load() {
        FileConfig config = FreeRank.get().getMainConfig();
        this.claimedplayers = new ArrayList<>(config.getStringList("CLAIMED.PLAYERS"));
        this.canclaim = config.getBoolean("CAN-CLAIM");
    }

    public boolean isReclaimed(String name) {
        return this.claimedplayers.contains(name);
    }

    public void addReclaimed(String name) {
        if (!this.claimedplayers.contains(name)) {
            this.claimedplayers.add(name);
            save();
        }
    }

    public boolean isClaimable() {
        return this.canclaim;
    }
}
