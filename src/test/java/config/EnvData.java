package config;

import lombok.Getter;

@Getter
public class EnvData {
    private String domain;
    private int wait;

    public String getHost() {
        return   "https://" + domain;
    }
}
