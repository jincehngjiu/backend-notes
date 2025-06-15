package com.eric.notes.Book;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author Eric Jin
 * @since 6/6/25 AM10:22
 */
public class Back {
     /* if (CollectionUtils.isEmpty(translateProdInfos)) {
            return;
        }

        // 提取所有prodId
        List<String> prodIds = translateProdInfos.stream()
                .map(ProdInfoDO::getProdId)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(prodIds)) {
            return;
        }

        // 批量查询，避免循环查询DB

        List<ProdTagDO> prodTagDoS = iprodInfoService.selectTagNamesByProdIds(prodIds);
        List<ProdBrandInfoVo> prodBrandInfoVos = iprodInfoService.selectBrandNamesByProdIds(prodIds);
        List<ProdSortInfoVo> prodSortInfoVos = iprodInfoService.selectSortNamesByProdIds(prodIds);

        Map<String, List<String>> prodNatureDoGroupByProdId = prodNatureDoS.stream()
                .collect(Collectors.groupingBy
                        (ProdNatureDO::getProdId,
                                Collectors.mapping(ProdNatureDO::getNatureName, Collectors.toList())
                        ));

        Map<String, List<String>> prodTagDoGroupByProdId = prodTagDoS.stream()
                .collect(Collectors.groupingBy
                        (ProdTagDO::getProdId,
                                Collectors.mapping(ProdTagDO::getTagName, Collectors.toList())
                        ));


        Map<String, ProdBrandInfoVo> brandNameMap =
                prodBrandInfoVos.stream()
                        .collect(Collectors.toMap(
                                ProdBrandInfoVo::getProdId,
                                Function.identity(),
                                (existing, replacement) -> existing
                        ));

        Map<String, ProdSortInfoVo> prodSortInfoVoMap =
                prodSortInfoVos.stream()
                        .collect(Collectors.toMap(
                                ProdSortInfoVo::getProdId,
                                Function.identity(),
                                (existing, replacement) -> existing
                        ));


        List<ProdInfoRequest> prodInfoRequests = translateProdInfos.stream()
                .flatMap(prodInfo -> {
                    String prodId = prodInfo.getProdId();

                    List<String> natures = prodNatureDoGroupByProdId.getOrDefault(prodId, Collections.emptyList());
                    List<String> tags = prodTagDoGroupByProdId.getOrDefault(prodId, Collections.emptyList());

                    ProdBrandInfoVo brand = brandNameMap.get(prodId);
                    ProdSortInfoVo sort = prodSortInfoVoMap.get(prodId);

                    return natures.stream().flatMap(nature ->
                            tags.stream().map(tag ->
                                    ProdInfoRequest.builder()
                                            .uniqueId(snowflakeConfig.snowflake().nextIdStr())
                                            .sysId(PIM.name())
                                            .goodsId(prodId)
                                            .type(BeesGoodsJsonStrDataTypeEnum.goods.name())
                                            .prodName(prodInfo.getProdName())
                                            .prodMaterial(prodInfo.getProdMaterial())
                                            .prodSpec(prodInfo.getProdSpec())
                                            .salePkg(prodInfo.getSalePkg())
                                            .declName(prodInfo.getDeclName())
                                            .sellingPoint(prodInfo.getSellingPoint())
                                            .model(prodInfo.getModel())
                                            .title(prodInfo.getTitle())
                                            .brandId(brand != null ? brand.getBrandId() : StringUtils.EMPTY)
                                            .brandName(brand != null ? brand.getBrandName() : StringUtils.EMPTY)
                                            .sortId(sort != null ? sort.getSortId() : StringUtils.EMPTY)
                                            .sortFullName(sort != null ? sort.getSortFullName() : StringUtils.EMPTY)
                                            .natureId(prodId)
                                            .natureName(nature)
                                            .tagId(prodId)
                                            .tagName(tag)
                                            .build()
                            )
                    );
                })
                .collect(Collectors.toList());*/
}
