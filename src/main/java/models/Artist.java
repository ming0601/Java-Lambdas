package models;

import java.util.Set;
import java.util.stream.Stream;

public class Artist {
    private String name;
    private Stream<Artist> members;
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stream<Artist> getMembers() {
        return members;
    }

    public void setMembers(Stream<Artist> members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
