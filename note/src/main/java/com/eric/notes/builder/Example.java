package com.eric.notes.builder;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Eric Jin
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ToString
@Getter
@RequiredArgsConstructor
public class Example implements Serializable {

    @Serial
    private static final long serialVersionUID = 4106160108141301226L;

    private final Long id;

    private final String ownerCode;

    private final String skuCode;

    private final String skc;

    private final Byte skuType;

    private final String storageCode;

    private final Byte storageType;

    private final Integer invType;

    private final String bizLotNo;

    private final Long invId;

    private final String bizOrderNo;

    private final Integer bizOrderType;

    private final Integer expectQty;

    private final Integer actualQty;

    private final String warehouseGroupCode;

    private final Byte diffType;

    private final Byte diffSubType;

    private final String extFields;

    private final Byte state;

    private final Integer retryTimes;

    private final String failReason;

    private final Integer version;

    private final LocalDateTime insertTime;

    private final LocalDateTime lastUpdateTime;

    private final Boolean delete;

    private final String inventoryTiers;

    private final String sourceBizType;

    private final String sourceBizCategory;

    public Example(Builder builder) {
        id = builder.id;
        ownerCode = builder.ownerCode;
        skuCode = builder.skuCode;
        skc = builder.skc;
        skuType = builder.skuType;
        storageCode = builder.storageCode;
        storageType = builder.storageType;
        invType = builder.invType;
        bizLotNo = builder.bizLotNo;
        invId = builder.invId;
        bizOrderNo = builder.bizOrderNo;
        bizOrderType = builder.bizOrderType;
        expectQty = builder.expectQty;
        actualQty = builder.actualQty;
        warehouseGroupCode = builder.warehouseGroupCode;
        diffType = builder.diffType;
        diffSubType = builder.diffSubType;
        extFields = builder.extFields;
        state = builder.state;
        retryTimes = builder.retryTimes;
        failReason = builder.failReason;
        version = builder.version;
        insertTime = builder.insertTime;
        lastUpdateTime = builder.lastUpdateTime;
        delete = builder.delete;
        inventoryTiers = builder.inventoryTiers;
        sourceBizType = builder.sourceBizType;
        sourceBizCategory = builder.sourceBizCategory;

    }

    @NoArgsConstructor(staticName = "getInstance")
    public static final class Builder {
        private Long id;
        private String ownerCode;
        private String skuCode;
        private String skc;
        private Byte skuType;
        private String storageCode;
        private Byte storageType;
        private Integer invType;
        private String bizLotNo;
        private Long invId;
        private String bizOrderNo;
        private Integer bizOrderType;
        private Integer expectQty;
        private Integer actualQty;
        private String warehouseGroupCode;
        private Byte diffType;
        private Byte diffSubType;
        private String extFields;
        private Byte state;
        private Integer retryTimes;
        private String failReason;
        private Integer version;
        private LocalDateTime insertTime;
        private LocalDateTime lastUpdateTime;
        private Boolean delete;
        private String inventoryTiers;
        private String sourceBizType;
        private String sourceBizCategory;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder ownerCode(String ownerCode) {
            this.ownerCode = ownerCode;
            return this;
        }

        public Builder skuCode(String skuCode) {
            this.skuCode = skuCode;
            return this;
        }

        public Builder skc(String skc) {
            this.skc = skc;
            return this;
        }

        public Builder skuType(Byte skuType) {
            this.skuType = skuType;
            return this;
        }

        public Builder storageCode(String storageCode) {
            this.storageCode = storageCode;
            return this;
        }

        public Builder storageType(Byte storageType) {
            this.storageType = storageType;
            return this;
        }

        public Builder invType(Integer invType) {
            this.invType = invType;
            return this;
        }

        public Builder bizLotNo(String bizLotNo) {
            this.bizLotNo = bizLotNo;
            return this;
        }

        public Builder invId(Long invId) {
            this.invId = invId;
            return this;
        }

        public Builder bizOrderNo(String bizOrderNo) {
            this.bizOrderNo = bizOrderNo;
            return this;
        }

        public Builder bizOrderType(Integer bizOrderType) {
            this.bizOrderType = bizOrderType;
            return this;
        }

        public Builder expectQty(Integer expectQty) {
            this.expectQty = expectQty;
            return this;
        }

        public Builder actualQty(Integer actualQty) {
            this.actualQty = actualQty;
            return this;
        }

        public Builder warehouseGroupCode(String warehouseGroupCode) {
            this.warehouseGroupCode = warehouseGroupCode;
            return this;
        }

        public Builder diffType(Byte diffType) {
            this.diffType = diffType;
            return this;
        }

        public Builder diffSubType(Byte diffSubType) {
            this.diffSubType = diffSubType;
            return this;
        }

        public Builder extFields(String extFields) {
            this.extFields = extFields;
            return this;
        }

        public Builder state(Byte state) {
            this.state = state;
            return this;
        }

        public Builder retryTimes(Integer retryTimes) {
            this.retryTimes = retryTimes;
            return this;
        }

        public Builder failReason(String failReason) {
            this.failReason = failReason;
            return this;
        }

        public Builder version(Integer version) {
            this.version = version;
            return this;
        }

        public Builder insertTime(LocalDateTime insertTime) {
            this.insertTime = insertTime;
            return this;
        }

        public Builder lastUpdateTime(LocalDateTime lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
            return this;
        }

        public Builder delete(Boolean delete) {
            this.delete = delete;
            return this;
        }

        public Builder inventoryTiers(String inventoryTiers) {
            this.inventoryTiers = inventoryTiers;
            return this;
        }

        public Builder sourceBizType(String sourceBizType) {
            this.sourceBizType = sourceBizType;
            return this;
        }

        public Builder sourceBizCategory(String sourceBizCategory) {
            this.sourceBizCategory = sourceBizCategory;
            return this;
        }

        public Example build() {
            return new Example(this);
        }
    }


}