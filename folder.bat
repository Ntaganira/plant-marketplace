@echo off
title Plant Marketplace Enterprise Structure

echo Creating Plant Marketplace structure...


cd src\main\java\rw\heritier

:: =================================================
:: CORE MODULES
:: =================================================
mkdir auth
mkdir users
mkdir vendors
mkdir products
mkdir categories
mkdir carts
mkdir orders
mkdir payments
mkdir reviews
mkdir notifications
mkdir storage
mkdir admin
mkdir shared

:: =================================================
:: INFRASTRUCTURE
:: =================================================
mkdir config
mkdir security
mkdir exception

:: =================================================
:: STANDARD LAYERS INSIDE EACH MODULE
:: =================================================

for %%m in (
    auth
    users
    vendors
    products
    categories
    carts
    orders
    payments
    reviews
    notifications
    storage
    admin
) do (

    mkdir %%m\controller
    mkdir %%m\service
    mkdir %%m\repository
    mkdir %%m\entity
    mkdir %%m\dto
    mkdir %%m\mapper
    mkdir %%m\request
    mkdir %%m\response

)

:: =================================================
:: SHARED PACKAGE
:: =================================================
mkdir shared\constants
mkdir shared\utils
mkdir shared\enums
mkdir shared\payload
mkdir shared\validator






echo.
echo ================================================
echo Plant Marketplace Enterprise Structure Created!
echo ================================================

pause