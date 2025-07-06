
---

## ✅ `docs/origin_story.md`

```markdown
# 📖 The Origin Story

## 🎬 How It Started

I had a small FPV drone that used an RC remote for control — until I lost the remote.

Thankfully, the drone also supported control via a smartphone app over WiFi. I began using the app (`RCFPVPro`) to fly the drone, but one day, my mentor **Jemshid Sir** casually asked:

> "Why not control it from your computer, like a video game using W, A, S, D, and Space?"

That question flipped a switch.

---

## 🔍 From Frustration to Innovation

I searched everywhere for an SDK, API, or library — **nothing worked** with this specific drone.  
So I turned to what I know best — **cybersecurity tactics**.

What if I could just capture what the app sends and replicate it?

---

## 🛰️ Capturing the Signals

1. Installed [PCAPdroid](https://github.com/emanuele-f/PCAPdroid) on Android  
2. Connected the phone to the drone’s WiFi  
3. Started capturing network traffic  
4. Opened the **RCFPVPro** app  
5. Pressed **“Takeoff”**  
6. Drone took off, and I captured **all UDP traffic** from phone to drone  
7. Stopped capture and exported the `.pcap` file

---

## 🧠 From Packet to Payload

Opened the `.pcap` in Wireshark → filtered packets → found the exact **UDP payload** used for takeoff.  
Built a Python script using `socket` to send the same payload manually from my PC.

Ran the script…  
**The drone took off — no phone needed.**

---

## 🎯 What This Means

This project is not just about drones.

It’s about:
- Breaking open black boxes  
- Learning from observation  
- Building tools when none exist  
- Recreating control without vendor APIs

Every payload in this repo was tested live.  
Every packet reverse-engineered manually.

---

## 🚀 What’s Next

- Mapping throttle, pitch, yaw, and flips  
- Creating real-time WASD-based controls  
- Designing a GUI to replace the mobile app  
- Building an open-source drone control protocol for similar FPV devices

This is just the beginning.  
**The real flight starts now.**

---

> 🧠 *"If it talks over the air, we can listen. If it listens, we can speak."*
