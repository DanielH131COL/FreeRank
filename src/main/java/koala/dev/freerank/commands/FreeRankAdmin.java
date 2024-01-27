package koala.dev.freerank.commands;

import koala.dev.freerank.FreeRank;
import koala.dev.freerank.utils.FileConfig;

import java.util.ArrayList;

public class FreeRankAdmin {
    private ArrayList<String> claimedplayers = new ArrayList<>();

    private boolean canclaim = false;

    public void save() {
        FileConfig config = FreeRank.get().getMainConfig();
        config.getConfiguration().set("claimed_players", this.claimedplayers);
        config.getConfiguration().set("can_claim", Boolean.valueOf(isClaimable()));
        config.save();
        config.reload();
    }

    public void load() {
        FileConfig config = FreeRank.get().getMainConfig();
        this.claimedplayers = new ArrayList<>(config.getStringList("claimed_players"));
        this.canclaim = config.getBoolean("can_claim");
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

    public void removeReclaimed(String name) {
        if (this.claimedplayers.contains(name)) {
            this.claimedplayers.remove(name);
            save();
        }
    }

    public void setClaimable(boolean bol) {
        this.canclaim = bol;
        save();
    }

    public ArrayList<String> getClaimedPlayers() {
        return this.claimedplayers;
    }

    public boolean isClaimable() {
        return this.canclaim;
    }
}
