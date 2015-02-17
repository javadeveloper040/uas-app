/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.edu.uams.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammed.Tauseef
 */
@Entity
@Table(name = "fee_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FeeTab.findAll", query = "SELECT f FROM FeeTab f"),
    @NamedQuery(name = "FeeTab.findByFeeCode", query = "SELECT f FROM FeeTab f WHERE f.feeTabPK.feeCode = :feeCode"),
    @NamedQuery(name = "FeeTab.findByFeeName", query = "SELECT f FROM FeeTab f WHERE f.feeTabPK.feeName = :feeName"),
    @NamedQuery(name = "FeeTab.findByFeeType", query = "SELECT f FROM FeeTab f WHERE f.feeType = :feeType"),
    @NamedQuery(name = "FeeTab.findByAdmnType", query = "SELECT f FROM FeeTab f WHERE f.admnType = :admnType"),
    @NamedQuery(name = "FeeTab.findByFeeCat", query = "SELECT f FROM FeeTab f WHERE f.feeCat = :feeCat"),
    @NamedQuery(name = "FeeTab.findByFeeGroup", query = "SELECT f FROM FeeTab f WHERE f.feeGroup = :feeGroup"),
    @NamedQuery(name = "FeeTab.findByCounterNum", query = "SELECT f FROM FeeTab f WHERE f.counterNum = :counterNum"),
    @NamedQuery(name = "FeeTab.findByReceiptType", query = "SELECT f FROM FeeTab f WHERE f.receiptType = :receiptType"),
    @NamedQuery(name = "FeeTab.findByOrigAmount", query = "SELECT f FROM FeeTab f WHERE f.origAmount = :origAmount")})
public class FeeTab implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FeeTabPK feeTabPK;
    @Basic(optional = false)
    @Column(name = "fee_type")
    private String feeType;
    @Basic(optional = false)
    @Column(name = "admn_type")
    private String admnType;
    @Basic(optional = false)
    @Column(name = "fee_cat")
    private String feeCat;
    @Basic(optional = false)
    @Column(name = "fee_group")
    private String feeGroup;
    @Basic(optional = false)
    @Column(name = "counter_num")
    private String counterNum;
    @Basic(optional = false)
    @Column(name = "receipt_type")
    private String receiptType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "orig_amount")
    private BigDecimal origAmount;
    @JoinColumn(name = "account_name", referencedColumnName = "account_name")
    @ManyToOne(optional = false)
    private Account accountName;

    public FeeTab() {
    }

    public FeeTab(FeeTabPK feeTabPK) {
        this.feeTabPK = feeTabPK;
    }

    public FeeTab(FeeTabPK feeTabPK, String feeType, String admnType, String feeCat, String feeGroup, String counterNum, String receiptType) {
        this.feeTabPK = feeTabPK;
        this.feeType = feeType;
        this.admnType = admnType;
        this.feeCat = feeCat;
        this.feeGroup = feeGroup;
        this.counterNum = counterNum;
        this.receiptType = receiptType;
    }

    public FeeTab(String feeCode, String feeName) {
        this.feeTabPK = new FeeTabPK(feeCode, feeName);
    }

    public FeeTabPK getFeeTabPK() {
        return feeTabPK;
    }

    public void setFeeTabPK(FeeTabPK feeTabPK) {
        this.feeTabPK = feeTabPK;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getAdmnType() {
        return admnType;
    }

    public void setAdmnType(String admnType) {
        this.admnType = admnType;
    }

    public String getFeeCat() {
        return feeCat;
    }

    public void setFeeCat(String feeCat) {
        this.feeCat = feeCat;
    }

    public String getFeeGroup() {
        return feeGroup;
    }

    public void setFeeGroup(String feeGroup) {
        this.feeGroup = feeGroup;
    }

    public String getCounterNum() {
        return counterNum;
    }

    public void setCounterNum(String counterNum) {
        this.counterNum = counterNum;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public BigDecimal getOrigAmount() {
        return origAmount;
    }

    public void setOrigAmount(BigDecimal origAmount) {
        this.origAmount = origAmount;
    }

    public Account getAccountName() {
        return accountName;
    }

    public void setAccountName(Account accountName) {
        this.accountName = accountName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feeTabPK != null ? feeTabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FeeTab)) {
            return false;
        }
        FeeTab other = (FeeTab) object;
        if ((this.feeTabPK == null && other.feeTabPK != null) || (this.feeTabPK != null && !this.feeTabPK.equals(other.feeTabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mylearning.FeeTab[ feeTabPK=" + feeTabPK + " ]";
    }
    
}