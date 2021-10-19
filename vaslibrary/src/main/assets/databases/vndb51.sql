DROP VIEW IF EXISTS "CustomerCallReturnView";
CREATE VIEW "CustomerCallReturnView" AS
SELECT
	CustomerCallReturnLinesView.UniqueId,
	CustomerCallReturnLinesView.StockId,
	CustomerCallReturnLinesView.CustomerUniqueId AS CustomerUniqueId,
	CustomerCallReturnLinesView.ReturnUniqueId AS ReturnUniqueId,
	CustomerCallReturnLinesView.InvoiceId AS InvoiceId,
	group_concat(ReturnProductTypeId, ':') AS ReturnProductTypeId,
	group_concat(ReturnReasonId, ':') AS ReturnReasonId,
	CustomerCallReturnLinesView.ProductName AS ProductName,
	CustomerCallReturnLinesView.ProductCode AS ProductCode,
	CustomerCallReturnLinesView.ProductId AS ProductId,
	group_concat(CustomerCallReturnLinesView.ConvertFactor,'|') AS ConvertFactor,
	group_concat(CustomerCallReturnLinesView.ProductUnitId,'|') AS ProductUnitId,
	group_concat(CustomerCallReturnLinesView.Qty,'|') AS Qty,
	group_concat(CustomerCallReturnLinesView.UnitName,'|') AS UnitName,
	sum(CustomerCallReturnLinesView.TotalReturnQty) AS TotalReturnQty,
	CustomerOldInvoiceDetail.TotalQty AS InvoiceQty,
	CustomerOldInvoiceHeader.SaleNo AS SaleNo,
	CustomerCallReturnLinesView.RequestUnitPrice,
	CASE WHEN CustomerCallReturnLinesView.IsPromoLine THEN
		ifnull(CustomerCallReturnLinesView.TotalRequestNetAmount,0) -
		ifnull(CustomerCallReturnLinesView.TotalRequestDiscount,0) +
		ifnull(CustomerCallReturnLinesView.TotalRequestAdd2Amount,0) +
		ifnull(CustomerCallReturnLinesView.TotalRequestTax,0) +
		ifnull(CustomerCallReturnLinesView.TotalRequestCharge,0)
	ELSE
		ifnull(CustomerCallReturnLinesView.TotalRequestAmount,0)
	END  AS TotalRequestAmount
FROM CustomerCallReturnLinesView
JOIN ReturnReason ON ReturnReason.UniqueId = CustomerCallReturnLinesView.ReturnReasonId
LEFT JOIN CustomerOldInvoiceDetail ON CustomerOldInvoiceDetail.ProductId = CustomerCallReturnLinesView.ProductId
and CustomerOldInvoiceDetail.SaleId = CustomerCallReturnLinesView.InvoiceId
LEFT JOIN CustomerOldInvoiceHeader ON CustomerOldInvoiceHeader.UniqueId = CustomerOldInvoiceDetail.SaleId
AND CustomerOldInvoiceDetail.SaleId = CustomerCallReturnLinesView.InvoiceId
GROUP BY CustomerCallReturnLinesView.ProductId, ReturnUniqueId;