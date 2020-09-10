package com.webank.wecrosssdk.rpc.common.account;

import com.google.common.base.Objects;
import java.util.List;

public class UniversalAccount {

    private String username;
    private String password;
    private String pubKey;
    private String secKey;
    private String uaID;
    private List<ChainAccount> chainAccounts;

    public UniversalAccount(
            String username,
            String password,
            String pubKey,
            String secKey,
            String uaID,
            List<ChainAccount> chainAccounts) {
        this.username = username;
        this.password = password;
        this.pubKey = pubKey;
        this.secKey = secKey;
        this.uaID = uaID;
        this.chainAccounts = chainAccounts;
    }

    public UniversalAccount(String username, String password, List<ChainAccount> chainAccounts) {
        this.username = username;
        this.password = password;
        this.chainAccounts = chainAccounts;
    }

    public UniversalAccount() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getPubKey() {
        return pubKey;
    }

    public String getSecKey() {
        return secKey;
    }

    public String getUaID() {
        return uaID;
    }

    public void setUaID(String uaID) {
        this.uaID = uaID;
    }

    public List<ChainAccount> getChainAccounts() {
        return chainAccounts;
    }

    public void setChainAccounts(List<ChainAccount> chainAccounts) {
        this.chainAccounts = chainAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UniversalAccount)) return false;
        UniversalAccount that = (UniversalAccount) o;
        return Objects.equal(username, that.username)
                && Objects.equal(pubKey, that.pubKey)
                && Objects.equal(uaID, that.uaID);
    }

    @Override
    public String toString() {
        StringBuilder result =
                new StringBuilder(
                        "{"
                                + "\"name\":\""
                                + username
                                + "\""
                                + ", \"pubKey\":\""
                                + pubKey
                                + "\""
                                + ", \"uaId\":\""
                                + uaID
                                + "\"");

        if (chainAccounts != null && chainAccounts.size() != 0) {
            result.append(", \"chainAccounts\": [");
            for (ChainAccount chainAccount : chainAccounts) {
                result.append(chainAccount.toString()).append(",");
            }
            result.deleteCharAt(result.lastIndexOf(","));
            result.append("]");
        }
        result.append("}");
        return result.toString();
    }

    public String toFormatString() {
        StringBuilder result = new StringBuilder("Universal Account:\n");
        result.append("name  : ").append(username).append("\n");
        result.append("pubKey: ").append(pubKey).append("\n");
        result.append("uaId  : ").append(uaID).append("\n");
        if (chainAccounts != null && chainAccounts.size() != 0) {
            result.append("chainAccounts: [\n");
            for (ChainAccount chainAccount : chainAccounts) {
                result.append(chainAccount.toFormatString());
            }
            result.append("]");
        }
        return result.toString();
    }
}
